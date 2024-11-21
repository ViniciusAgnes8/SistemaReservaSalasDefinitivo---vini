// Abrir o modal ao clicar no botão
document.getElementById('btnAddUser').onclick = function() {
    document.getElementById('addUserModal').style.display = "block";
};

// Fechar o modal ao clicar no "X"
document.getElementById('closeModal').onclick = function() {
    document.getElementById('addUserModal').style.display = "none";
};

// Fechar o modal se o usuário clicar fora dele
window.onclick = function(event) {
    if (event.target == document.getElementById('addUserModal')) {
        document.getElementById('addUserModal').style.display = "none";
    }
};
