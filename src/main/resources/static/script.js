document.addEventListener("DOMContentLoaded", function() {
    const btnDelete = document.querySelectorAll(".btn-delete");

    btnDelete.forEach(button => {
        button.addEventListener("click", function(e) {
            const confirmation = confirm("Tem certeza de que deseja excluir este item?");
            if (!confirmation) {
                e.preventDefault();
            }
        });
    });
});

// Função para filtrar equipamentos pela pesquisa e pelo estado
document.getElementById("search").addEventListener("input", filterEquipment);
document.getElementById("state-filter").addEventListener("change", filterEquipment);

function filterEquipment() {
    const searchQuery = document.getElementById("search").value.toLowerCase();
    const selectedState = document.getElementById("state-filter").value.toLowerCase();
    const rows = document.querySelectorAll("#equipment-list tr");

    rows.forEach(row => {
        const equipmentName = row.cells[1].textContent.toLowerCase();
        const equipmentState = row.cells[2].textContent.toLowerCase();
        
        // Verifica se o equipamento corresponde ao filtro de pesquisa e de estado
        const matchesSearch = equipmentName.includes(searchQuery);
        const matchesState = selectedState ? equipmentState.includes(selectedState) : true;

        if (matchesSearch && matchesState) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    });
}

function openModal(modalId) {
    document.getElementById(modalId).style.display = "block";
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = "none";
}

// Fechar o modal ao clicar fora da área de conteúdo
window.onclick = function(event) {
    var modals = document.querySelectorAll('.modal');
    modals.forEach(function(modal) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    });
}

function filterTable() {
    const filterID = document.getElementById("filter-id").value.toLowerCase();
    const filterNomeSala = document.getElementById("filter-nome-sala").value.toLowerCase();
    const filterDataReserva = document.getElementById("filter-data-reserva").value;
    const filterHorario = document.getElementById("filter-horario").value.toLowerCase();
    const filterUsuario = document.getElementById("filter-usuario").value.toLowerCase();
    
    const table = document.getElementById("reservas-table");
    const rows = table.getElementsByTagName("tr");

    for (let i = 1; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName("td");
        const id = cells[0].innerText.toLowerCase();
        const nomeSala = cells[1].innerText.toLowerCase();
        const dataReserva = cells[2].innerText;
        const horario = cells[3].innerText.toLowerCase();
        const usuario = cells[4].innerText.toLowerCase();

        const showRow = 
            (!filterID || id.includes(filterID)) &&
            (!filterNomeSala || nomeSala.includes(filterNomeSala)) &&
            (!filterDataReserva || dataReserva.includes(filterDataReserva)) &&
            (!filterHorario || horario.includes(filterHorario)) &&
            (!filterUsuario || usuario.includes(filterUsuario));

        rows[i].style.display = showRow ? "" : "none";
    }
}

function openReserveModal(equipmentName) {
    document.getElementById("reserveModal").style.display = "block";
    document.getElementById("reserveForm").reset();
}

function closeReserveModal() {
    document.getElementById("reserveModal").style.display = "none";
}

document.getElementById("reserveForm").addEventListener("submit", function(event) {
    event.preventDefault();
    // Aqui você pode adicionar código para salvar a reserva e fechar o modal
    alert("Reserva confirmada!");
    closeReserveModal();
});

function openReservePopup() {
    document.getElementById("reservePopup").style.display = "block";
}

function closeReservePopup() {
    document.getElementById("reservePopup").style.display = "none";
}

// Fechar o popup ao clicar fora dele
window.onclick = function(event) {
    const modal = document.getElementById("reservePopup");
    if (event.target === modal) {
        closeReservePopup();
    }
};

document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita o envio do formulário

    // Captura os valores dos campos
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Validação simples (Você pode adicionar mais verificações aqui)
    if (username === '' || password === '') {
        showError('Por favor, preencha todos os campos.');
    } else {
        // Aqui você pode adicionar a lógica de autenticação
        if (username === 'admin' && password === 'senha123') {
            window.location.href = 'dashboard.html'; // Redireciona para o dashboard
        } else {
            showError('Usuário ou senha incorretos.');
        }
    }
});

// Função para exibir mensagem de erro
function showError(message) {
    const errorMessageElement = document.getElementById('error-message');
    errorMessageElement.textContent = message;
}
