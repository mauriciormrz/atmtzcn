@Regresion
Feature: Reto para interactuar con algunas alertas de JavaScript

  @CasoExitoso
  Scenario Outline: JavaScript Alerts
    Given Que el usuario ingresa a la pagina de herokuapp
    When Selecciona el link JavaScript Alerts
    Then Interactua con los controles que hay en esta pantalla
      | <BotonAlert> | <ResultAlert> | <BotonConfirm> | <BotonPrompt> | <MensajePrompt> |


    Examples: 
      | BotonAlert | ResultAlert                      | BotonConfirm | BotonPrompt | MensajePrompt |
      | Aceptar    | You successfuly clicked an alert | Cancelar     | Aceptar     | Hola Mundo    |
