function openReserveModal(equipamentoId, nomeEquipamento) {
    // Preenche os dados no modal
    document.getElementById("equipamento-id").value = equipamentoId;
    document.getElementById("nome-equipamento").textContent = nomeEquipamento;
    
    // Exibe o modal
    document.getElementById("reserve-modal").style.display = "block";
}

function closeReserveModal() {
    // Fecha o modal
    document.getElementById("reserve-modal").style.display = "none";
}

function handleReservation(event) {
    event.preventDefault(); // Evita o envio padrão do formulário

    alert('Reserva confirmada');
}
