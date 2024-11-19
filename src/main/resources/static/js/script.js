// Função para abrir o popup
function openPopup() {
    document.getElementById('userPopup').style.display = 'block';
}

// Função para fechar o popup
function closePopup() {
    document.getElementById('userPopup').style.display = 'none';
}

// Lidar com o envio do formulário
document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio padrão do formulário

    // Coletar dados do formulário
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const role = document.getElementById('role').value;

    // Exibir os dados no console (aqui você pode implementar a lógica de envio para o backend)
    console.log('Usuário:', username);
    console.log('E-mail:', email);
    console.log('Nível de Acesso:', role);

    // Fechar o popup após o envio
    closePopup();

    // Limpar os campos do formulário
    document.getElementById('userForm').reset();
});
