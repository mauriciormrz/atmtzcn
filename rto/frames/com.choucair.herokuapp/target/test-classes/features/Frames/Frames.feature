@Regresion
Feature: Reto para interactuar con algunas Frames

  @CasoExitosoFrames
  Scenario Outline: NestedFrames y iFrames
    Given Que el usuario ingresa a la pagina de herokuapp
    When Selecciona el link Frames
    Then Interactua con los Nested Frames
    And Interactua con los iFrames
      | <Mensaje> |

    Examples: 
      | Mensaje    |
      | Hola Mundo |
