// Função para atualizar a tabela de salas
function updateRoomReport(data) {
    const tbody = document.getElementById("generalRoomBody");
    tbody.innerHTML = "";
    data.forEach(room => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${room.id}</td>
            <td>${room.name}</td>
            <td>${room.responsible}</td>
            <td>${room.lastDate}</td>
        `;
        tbody.appendChild(row);
    });
}

// Função para atualizar a tabela de equipamentos
function updateEquipmentReport(data) {
    const tbody = document.getElementById("generalEquipmentBody");
    tbody.innerHTML = "";
    data.forEach(equipment => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${equipment.id}</td>
            <td>${equipment.name}</td>
            <td>${equipment.responsible}</td>
            <td>${equipment.lastUsed}</td>
            <td>${equipment.lastMaintenance}</td>
            <td>${equipment.nextReview}</td>
        `;
        tbody.appendChild(row);
    });
}

// Função para realizar o filtro geral
function filterReports() {
    const generalDate = document.getElementById("generalDate").value;
    let filteredRooms = roomsData;
    let filteredEquipments = equipmentData;

    if (generalDate) {
        filteredRooms = roomsData.filter(room => room.lastDate === generalDate);
        filteredEquipments = equipmentData.filter(equipment => equipment.lastUsed === generalDate);
    }

    updateRoomReport(filteredRooms);
    updateEquipmentReport(filteredEquipments);
}

// Filtros do Relatório por Sala
function filterRoomReport() {
    const roomName = document.getElementById("roomName").value.toLowerCase();
    const filteredRooms = roomsData.filter(room => room.name.toLowerCase().includes(roomName));
    updateRoomReport(filteredRooms);
}

// Filtros do Relatório por Equipamento
function filterEquipmentReport() {
    const equipmentName = document.getElementById("equipmentName").value.toLowerCase();
    const filteredEquipments = equipmentData.filter(equipment => equipment.name.toLowerCase().includes(equipmentName));
    updateEquipmentReport(filteredEquipments);
}

// Função para alternar entre as abas de relatório
function toggleReportSections(activeSection) {
    console.log("Alternando para a seção:", activeSection);

    // Esconde todas as seções
    document.querySelectorAll(".report-section").forEach(section => section.classList.add("hidden"));

    // Mostra a seção ativa
    document.getElementById(activeSection).classList.remove("hidden");

    // Remove a classe "active" de todos os botões
    document.querySelectorAll(".report-button").forEach(btn => btn.classList.remove("active"));

    // Adiciona a classe "active" no botão correspondente
    document.getElementById(activeSection + "Btn").classList.add("active");
}

// Adicionar eventos de clique para alternar as abas
document.getElementById("generalReportBtn").addEventListener("click", () => toggleReportSections("generalReport"));
document.getElementById("roomReportBtn").addEventListener("click", () => toggleReportSections("roomReport"));
document.getElementById("equipmentReportBtn").addEventListener("click", () => toggleReportSections("equipmentReport"));

// Adicionar eventos de clique para os botões de filtro
document.getElementById("generalFilterButton").addEventListener("click", filterReports);
document.getElementById("roomFilterButton").addEventListener("click", filterRoomReport);
document.getElementById("equipmentFilterButton").addEventListener("click", filterEquipmentReport);

// Simulação de dados para exemplo
const roomsData = [
    { id: 1, name: "Sala A", responsible: "João", lastDate: "2024-10-15" },
    { id: 2, name: "Sala B", responsible: "Maria", lastDate: "2024-10-17" },
    { id: 3, name: "Sala C", responsible: "Lucas", lastDate: "2024-11-05" }
];

const equipmentData = [
    { id: 1, name: "Projetor", responsible: "Carlos", lastUsed: "2024-10-14", lastMaintenance: "2024-10-10", nextReview: "2024-11-10" },
    { id: 2, name: "Computador", responsible: "Ana", lastUsed: "2024-10-16", lastMaintenance: "2024-10-12", nextReview: "2024-11-15" },
    { id: 3, name: "Ar-condicionado", responsible: "Rafael", lastUsed: "2024-11-01", lastMaintenance: "2024-10-28", nextReview: "2024-12-01" }
];
