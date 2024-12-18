# README

## Principio de Sustitución de Liskov (LSP)

El Principio de Sustitución de Liskov (LSP) establece que las clases derivadas deben ser sustituibles por sus clases base sin alterar el comportamiento esperado del programa. Esto implica que una clase hija no debería restringir ni incumplir las promesas (contratos) realizadas por la clase padre.

## Problemas Detectados Antes de la Refactorización

Inicialmente teníamos una clase base `Animal` que incluía métodos generales, como `makeSound()` y `walk()`. Sin embargo, esto generaba un problema con ciertas subclases como `Fish`, las cuales no eran capaces de caminar. Esto llevaba a lanzar excepciones (`UnsupportedOperationException`) cuando se intentaba utilizar un `Fish` como si fuera un `Animal` genérico, rompiendo así el contrato y provocando errores en tiempo de ejecución.

En otras palabras, la clase `Fish` no cumplía con el principio LSP porque si sustituíamos un `Animal` por un `Fish`, nuestro programa dejaba de funcionar de manera coherente.

## Cómo se Aplicó el LSP en la Refactorización

1. **Separación de Comportamientos:**  
   Se eliminó el método `walk()` de la clase base `Animal` y se creó una interfaz específica para aquellos animales que pueden caminar, `WalkingAnimal`. De esta forma, solo las clases que realmente tienen la capacidad de caminar (por ejemplo, `Dog`) implementan esta interfaz.

2. **Enfoque en Contratos Comunes:**  
   La clase `Animal` quedó con el comportamiento mínimo común a todos los animales: el método `makeSound()`. Todos los animales pueden hacer un sonido, por lo que no hay riesgo de métodos no aplicables a una subclase.

3. **Uso de Interfaces Específicas:**  
   Al crear la interfaz `WalkingAnimal`, el método `walk()` deja de ser una obligación para todas las subclases de `Animal`. Ahora, `Fish` no intenta implementar `walk()`, y por ende no lanza excepciones ni rompe el LSP.

## Problemas que Resolvió la Refactorización

- **Incompatibilidad en la Jerarquía:**  
  Antes, `Fish` no podía comportarse como un `Animal` genérico sin lanzar excepciones al llamar a `walk()`. Ahora, cada subclase cumple con el contrato establecido: si es un `Animal`, hace `makeSound()`; si además es un `WalkingAnimal`, entonces puede caminar.

- **Excepciones Inesperadas:**  
  La excepción `UnsupportedOperationException` desapareció. No hay más métodos que no puedan ser implementados por ciertas subclases, ya que los comportamientos se asignan solo a las clases que los necesitan.

- **Mayor Flexibilidad y Mantenibilidad:**  
  La jerarquía de clases ahora es más flexible. Podemos agregar nuevos animales sin temor a que tengan que implementar métodos que no les corresponden, asegurando así que el LSP se mantenga. Esto facilita la mantenibilidad y la escalabilidad del código.

## Conclusión

La aplicación del Principio de Sustitución de Liskov nos llevó a reorganizar las jerarquías de clases y los contratos establecidos por ellas. Gracias a esta refactorización, cada subclase puede sustituir sin problemas a su superclase, cumpliendo con las expectativas del programa sin comportamientos inesperados ni excepciones no deseadas.
