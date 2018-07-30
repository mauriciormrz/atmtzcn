@Regresion
Feature: Noticias nacionales e internacionales diario el Tiempo

  @RegistroUsuario
  Scenario Outline: Registro en la aplicacion
    Given que ingreso a la pagina
    When realizo el registro
      | <nombre> | <apellidos> | <correo_electronico> | <contrasegna> |
    Then verifico el acceso a la aplicación

    Examples: 
      | nombre   | apellidos        | correo_electronico             | contrasegna     |
      | Mauricio | Ramirez Restrepo | ramirezmauricio@hotmail.com | ramirezmauricio |
