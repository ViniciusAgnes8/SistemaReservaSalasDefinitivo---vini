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
