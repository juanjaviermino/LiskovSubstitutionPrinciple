# Capturas de Pantalla

A continuación se presentan dos capturas de pantalla que demuestran el comportamiento del programa tras la refactorización y aplicación del Principio de Sustitución de Liskov.

## 1. Animal que Camina (Dog)

En esta captura se muestra la ejecución de un perro (`Dog`) realizando su sonido y utilizando el método `walk()` sin problemas:

![Dog walking](./evidence1.png)

## 2. Animal que No Camina (Fish)

En esta captura se muestra un pez (`Fish`) haciendo su sonido, pero sin intentar caminar, evitando así excepciones y cumpliendo con el LSP:

![Fish not walking](./evidence2.png)
