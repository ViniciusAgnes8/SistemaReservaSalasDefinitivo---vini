document.addEventListener("DOMContentLoaded", function () {

    var modal = document.getElementById("addUserModal");
    var btn = document.getElementById("btnAddUser");
    var span = document.getElementById("closeModal");

    // Quando o usuário clicar no botão, abre o modal
    btn.onclick = function() {
        modal.style.display = "block";
    }

    // Quando o usuário clicar no "X" (fechar), fecha o modal
    span.onclick = function() {
        modal.style.display = "none";
    }

    // Quando o usuário clicar fora do modal, fecha o modal
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    const form = document.getElementById('addUsuarioForm');

    form.addEventListener("submit", function (e) {
        e.preventDefault();
        
        const nome = document.getElementById("nome").value;
        const email = document.getElementById("email").value;
        const acesso = document.getElementById("acesso").value;
        const senha = document.getElementById("senha").value;

        if (!nome || !email || !acesso || !senha) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        form.submit();
    });

});
    