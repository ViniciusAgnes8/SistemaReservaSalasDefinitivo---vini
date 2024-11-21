document.getElementById('addUserForm').addEventListener('submit', function (e) {
    e.preventDefault();

    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const acesso = document.getElementById('tipoUsuario').value;
    const senha = document.getElementById('senha').value;

    const userList = document.getElementById('userList');

    // Adicionar usuário na tabela
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
        <td>${nome}</td>
        <td>${email}</td>
        <td>${acesso}</td>
        <td>
            <button onclick="openEditModal(this)">Editar</button>
            <button onclick="removerUsuario(this)">Remover</button>
        </td>
    `;
    userList.appendChild(newRow);

    // Simula envio à API
    console.log(`Usuário ${nome} adicionado com nível ${acesso}.`);

    // Limpa formulário
    e.target.reset();
});

function removerUsuario(button) {
    const row = button.parentElement.parentElement;
    row.remove();
    console.log('Usuário removido.');
}

function openEditModal(button) {
    const row = button.parentElement.parentElement;
    const nome = row.children[0].textContent;
    const email = row.children[1].textContent;
    const acesso = row.children[2].textContent;

    // Preenche o modal de edição com os dados do usuário
    document.getElementById('editNome').value = nome;
    document.getElementById('editEmail').value = email;
    document.getElementById('editTipoUsuario').value = acesso;

    // Abre o modal de edição
    openModal('editUserModal');

    // Salva o ID do usuário para edição
    const userId = row.getAttribute('data-user-id');
    document.getElementById('editUserId').value = userId;

    // Atualiza o evento de submit do modal de edição
    document.getElementById('editUserForm').onsubmit = function (e) {
        e.preventDefault();

        const nomeEditado = document.getElementById('editNome').value;
        const emailEditado = document.getElementById('editEmail').value;
        const tipoUsuarioEditado = document.getElementById('editTipoUsuario').value;

        // Atualiza a linha da tabela com os novos valores
        row.children[0].textContent = nomeEditado;
        row.children[1].textContent = emailEditado;
        row.children[2].textContent = tipoUsuarioEditado;

        // Simula envio à API
        console.log(`Usuário ${nomeEditado} atualizado.`);

        // Fecha o modal de edição
        closeModal('editUserModal');
    };
}

function openModal(modalId) {
    document.getElementById(modalId).style.display = 'block';
}

function closeModal(modalId) {
    document.getElementById(modalId).style.display = 'none';
}
