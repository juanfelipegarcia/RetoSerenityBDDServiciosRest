Feature: Usuario  Encontrado
  Yo como un nuevo Usuario de la página de la direccion https://jsonplaceholder.typicode.com/


  Scenario: Usuario encontrado
    Given el Cliente está en la Url https://jsonplaceholder.typicode.com/ y Busca el usuario
    When cuando el cliente realiza la peticion de busqueda  de usuario selecionado
    Then el cliente deberá ver un codigo de respuesta de usuario es encontrado