document.getElementById('search').addEventListener('input', filterRooms);
document.getElementById('capacity-filter').addEventListener('change', filterRooms);
document.getElementById('type-filter').addEventListener('change', filterRooms);

function filterRooms() {
    let searchTerm = document.getElementById('search').value.toLowerCase();
    let capacity = document.getElementById('capacity-filter').value;
    let type = document.getElementById('type-filter').value;
    let rows = document.querySelectorAll('#room-list tr');

    rows.forEach(row => {
        let name = row.cells[1].textContent.toLowerCase();
        let roomCapacity = row.cells[2].textContent;
        let roomType = row.cells[1].textContent;

        let match = true;
        if (searchTerm && !name.includes(searchTerm)) {
            match = false;
        }
        if (capacity && roomCapacity !== capacity) {
            match = false;
        }
        if (type && roomType !== type) {
            match = false;
        }

        row.style.display = match ? '' : 'none';
    });
}



function openReserveModal(button) {
    const salaId = button.getAttribute('data-sala-id')
    document.getElementById('reserve-modal').style.display = 'block'; // Exibe o modal
    document.getElementById('sala-id').value = salaId;
}

function closeReserveModal() {
    document.getElementById('reserve-modal').style.display = 'none'; // Fecha o modal
}

function handleReservation(event) {
    event.preventDefault();
    // Lógica para processar a reserva
    alert('Reserva confirmada!');
    closeReserveModal(); // Fecha o modal após confirmar
}
