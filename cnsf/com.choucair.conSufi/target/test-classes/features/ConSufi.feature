@Regresion
Feature: conSufi

  @CasoExitoso
  Scenario Outline: Consultar solicitantes y almacenamiento de data
    Given que ingreso a la URL con el Application ID correspondiente
      | <usuario> | <contrasegna> | <ApplicationId> | <intervalo> |
    When se despliega la informacion del solicitante
    Then se almacena su informacion en base de datos

    Examples: 
      | usuario  | contrasegna | ApplicationId | intervalo |
      | ormramir | ormramir    |         25029 |       10 |
