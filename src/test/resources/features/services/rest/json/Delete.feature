Feature: Eliminar informacion de usuario
  Yo como un nuevo Usuario de la página de la direccion https://jsonplaceholder.typicode.com/


  Scenario: Eliminar informacion de usuario
    Given el Usuario está en la Url https://jsonplaceholder.typicode.com/ y desea eliminar informacion de usuario.
    When cuando el Usuario realiza la peticion de eliminado  de usuario
    Then el Usuario deberá ver un codigo de respuesta de usuario eliminado