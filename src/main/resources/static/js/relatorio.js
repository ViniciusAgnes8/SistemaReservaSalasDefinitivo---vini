// Função para alternar entre as abas de relatório
function toggleReportSections(activeSection) {
    console.log("Alternando para a seção:", activeSection);

    // Esconde todas as seções
    document.querySelectorAll(".report-section").forEach(section => section.classList.remove("active"));

    // Mostra a seção ativa
    document.getElementById(activeSection).classList.add("active");

    // Remove a classe "active" de todos os botões
    document.querySelectorAll(".report-button").forEach(btn => btn.classList.remove("active"));

    // Adiciona a classe "active" no botão correspondente
    document.getElementById(activeSection + "Btn").classList.add("active");
}

// Inicializar a página com o relatório geral ativo
document.addEventListener("DOMContentLoaded", () => {
    toggleReportSections("generalReport");
});

// Adicionar eventos de clique para alternar as abas
document.getElementById("generalReportBtn").addEventListener("click", () => toggleReportSections("generalReport"));
document.getElementById("roomReportBtn").addEventListener("click", () => toggleReportSections("roomReport"));
document.getElementById("equipmentReportBtn").addEventListener("click", () => toggleReportSections("equipmentReport"));
