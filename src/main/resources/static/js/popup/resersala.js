// Função para abrir o modal de reserva
function openReserveModal(salaId, salaNome) {
    document.getElementById('reserve-modal').style.display = 'block';
    // Preencher o ID da sala no campo oculto para envio posterior
    document.getElementById('sala-id').value = salaId;
    // Preencher o nome da sala no título do modal
    document.querySelector('.modal-content h2').textContent = `Reservar Sala: ${salaNome}`;
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
    const salaId = document.getElementById('sala-id').value;

    // Simulação de requisição para reservar a sala (Você precisará implementar o back-end)
    // Aqui, vamos remover a sala da lista e adicioná-la à lista de reservas
    const salaLinha = document.getElementById(`sala-${salaId}`);
    if (salaLinha) {
        salaLinha.remove(); // Remove a sala da lista de salas disponíveis
    }

    // Agora, adicione a sala à lista de reservas na interface (essa parte é simulada)
    const reservasTable = document.getElementById('reservas-list');
    const newRow = document.createElement('tr');
    newRow.innerHTML = `<td>${salaId}</td><td>${nome}</td><td>${data}</td><td>${entrada} - ${saida}</td>`;
    reservasTable.appendChild(newRow);

    // Exemplo de confirmação de reserva
    alert('Reserva Confirmada!');

    // Fechar o modal
    closeReserveModal();
}
