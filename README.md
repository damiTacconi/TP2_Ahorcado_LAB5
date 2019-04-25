# TP2 - Ahorcado - LAB5

## Diferencia entre Runnable y Thread

### Thread

Un **Thread** es un hilo de ejecucion que puede ejecutar secuencias de codigo en simultaneo para realizar
diferentes tareas. Para crear una clase que pueda cumplir funciones multitarea, una opcion es heredar de
la clase Thread adquiriendo ademas todas las propiedades y comportamientos de la misma, luego se procede a sobre-escribir
el metodo **run()** e iniciar el hilo con el metodo **start()**

### Runnable

Por otro lado, **Runnable** es solo una interfaz que implementa el metodo **run()**. Al crear una instancia de Thread, este
puede recibir en su constructor un objeto que implemente dicha interfaz y luego ejecutarlo al invocar el metodo **start()**.
Esto tambien puede ser de utilidad en caso de que el objeto ya herede de otra clase y necesite ejecutar codigo multitarea.

## Ciclo de vida de un Thread

Un Thread puede tener cuatro tipos de estado:

![Ciclo de Vida de un Thread](http://3.bp.blogspot.com/-Li6r7FoUe5A/UIFRJKK4_GI/AAAAAAAAAEk/wgcVoICNtDU/s1600/CicloVidaThreadBasico.bmp)

* **Nuevo**: El Thread se creo pero no se ejecuto ( no hay llamada al metodo **start()** ) 
* **Ejecutable**: Para que el hilo que se creo pase al estado ejecutable se necesita llamar al método start(), durante su ejecucion 
es posible que pase al estado "bloqueado" a casua de una llamada al metodo sleep() o wait() por ejemplo, luego de un determinado
tiempo podra volver al estado "ejecutable"
* **Bloqueado**: Un hilo bloqueado puede estar: dormido (bloqueado durante una cantidad de tiempo determinada) o esperando (el hilo 
está esperando a que ocurra alguna cosa)
* **Muerto**: Este estado sucede cuando el Thread finaliza, puede ocurrir de manera natural al finalizar el metodo **run()** o por ejemplo a causa
de algun llamado al metodo **stop()**, **interrupt()**... o tambien a causa de una Excepcion.

## Metodos [start , sleep, yield , join]
* start(): usado para iniciar el cuerpo del thread definido por el método run().
* sleep(): pone a dormir un thread por un  tiempo mínimo especificado.
* join(): usado para esperar por el término del thread sobre la cual el método es invoacado, por ejemplo por término de método run().
* yield(): este metodo le cede el CPU a otro hilo pero no finaliza su ejecucion, solo lo mantendra en pausa momentaneamente, tambien puede suceder que el mismo hilo que llamo al metodo yield() vuelva a ser elegido para ejecutarse.
