@Regresion
Feature: Realizar una compra de un televisor para ver el mundial de fútbol
  en la página virtual del Éxito para que sea enviado a mi casa.

  @CasoExitoso
  Scenario Outline: Realizar una compra en la pagina del Exito y agregar el producto al carrito de compras
    Given Que ingreso a la pagina virtual
    And Hago una busqueda del producto
      | <Producto> |
    When Realizo los filtros del producto
      | <Tamano> | <Marca> | <Resolucion> |
    And Presento el resultado del filtro
    Then Agrego el producto al carrito de compras
    And Verifico el carrito

    Examples: 
      | Producto  | Tamano     | Marca | Resolucion |
      | Televisor | de 44 a 49 | LG    | HD        |
