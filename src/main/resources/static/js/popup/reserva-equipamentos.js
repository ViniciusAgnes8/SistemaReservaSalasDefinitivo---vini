// Abre o modal de reserva
function openReserveModal(equipamentoId, equipamentoNome) {
    console.log("Abrindo modal para", equipamentoId, equipamentoNome);
    document.getElementById('reserve-modal').classList.add('show');
    document.getElementById('equipamento-id').value = equipamentoId;
    document.getElementById('nome-equipamento').innerText = equipamentoNome;
}

// Fecha o modal de reserva
function closeReserveModal() {
    document.getElementById('reserve-modal').classList.remove('show');
}

// Filtro de Equipamentos por Nome
function filtrarEquipamentos() {
    const filtro = document.getElementById('filtroNome').value.toLowerCase();
    const linhas = document.querySelectorAll('#tabelaEquipamentos tr');

    linhas.forEach(function (linha) {
        const nomeEquipamento = linha.children[1].innerText.toLowerCase();
        if (nomeEquipamento.includes(filtro)) {
            linha.style.display = '';
        } else {
            linha.style.display = 'none';
        }
    });
}

// Enviar Formulário de Reserva via AJAX
document.getElementById('reserve-form').addEventListener('submit', function (event) {
    event.preventDefault();

    const formData = new FormData(this);

    fetch('/reservar-direto/salvar', {
        method: 'POST',
        body: JSON.stringify({
            idEquipamento: formData.get('idEquipamento'),
            nome: formData.get('nome'),
            email: formData.get('email'),
            data: formData.get('data'),
            entrada: formData.get('entrada'),
            saida: formData.get('saida')
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (response.ok) {
            alert("Reserva confirmada!");
            closeReserveModal();
        } else {
            alert("Erro ao realizar a reserva.");
        }
    });
});
