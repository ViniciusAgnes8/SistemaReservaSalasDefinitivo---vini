// Função para abrir o modal de reserva
function openReserveModal(equipamentoNome, equipamentoId) {
    document.getElementById('reserve-modal').style.display = 'block';
    // Preenche o ID do equipamento no campo oculto para envio posterior
    document.getElementById('equipamento-id').value = equipamentoId;
}

// Função para fechar o modal
function closeReserveModal() {
    document.getElementById('reserve-modal').style.display = 'none';
}

// Função para processar a reserva
function handleReservation(event) {
    event.preventDefault(); // Impede o envio padrão do formulário

    // Obter dados do formulário
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const data = document.getElementById('data').value;
    const entrada = document.getElementById('entrada').value;
    const saida = document.getElementById('saida').value;
    const equipamentoId = document.getElementById('equipamento-id').value;

    // Simulação de requisição para reservar o equipamento (Você precisará implementar o back-end)
    // Aqui, vamos remover o equipamento da lista e adicioná-lo à lista de reservas no front-end
    const equipamentoLinha = document.getElementById(`equipamento-${equipamentoId}`);
    if (equipamentoLinha) {
        equipamentoLinha.remove(); // Remove o equipamento da lista de equipamentos
    }

    // Agora, adicione o equipamento à lista de reservas na interface (essa parte é simulada)
    const reservasTable = document.getElementById('reservas-list');
    const newRow = document.createElement('tr');
    newRow.innerHTML = `<td>${equipamentoId}</td><td>${nome}</td><td>${data}</td><td>${entrada} - ${saida}</td>`;
    reservasTable.appendChild(newRow);

    // Exemplo de confirmação de reserva
    alert('Reserva Confirmada!');

    // Fechar o modal
    closeReserveModal();
}
