## Licencia
Copyright 2022 Gonzalo Paúl Fantoni, Carlos Alonso Gradillas e Ignacio Martín-Peña

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.


# Práctica 03 - Aprendizaje automático

El propósito de esta práctica es la implementación de uno de los algoritmos estudiados sobre un conjunto de datos. Para su posterior aprendizaje y predicción.

#### Elección del problema
La predicción de resultados de la competición UFC. 
#### Fuente de datos
Hemos escogido una bbdd pública de la UFC. La cual recoge todo tipo de datos sobre combates desde los últimos 10 años.
```
https://www.kaggle.com/datasets/mdabbert/ultimate-ufc-dataset
```
#### Atributos relevantes
Tras una serie de pruebas y tests, los atributos que hemos seleccionado y mejor resultado nos han dado han sido:
1. Racha de victorias
2. La postura de los combatientes (zurdos, diestros)
3. Alcance en cm

#### Elección del algoritmo
Hemos elegido randomforest ya que nos brindaba las mejores tasas de TP, y F measure. Además, también son muy eficientes en términos de tiempo de entrenamiento y rendimiento en general.

# Instrucciones de uso
Dentro de la carpeta App_Java:
1. Ejecutar makefile, para crear el archivo .jar
```bash
$- make jar
```
2. Ejecutar la app (archivo .jar obtenido en el paso anterior)
```
$- java -jar aprendizaje.jar
```
3. Introducir los datos por pantalla en el siguiente orden y separados por comas, sin espacios entre sí.
```
RachaVictoriasBlue, PosturaBlue, AlcanceBlue, RachaVictoriasRed, PosturaRed, AlcanceRed, ?
```
**Importante añadir '?' al final, para que el modelo prediga el resultado del combate.
Devolverá BLUE, si gana el primer combatiente, y RED si gana el segundo combatiente.

# Ejemplo
Una vez ejecutada la aplicación, si nos interesa saber la predicción sobre el siguiente combate:
1. Combatiente 1: 3 victorias, diestro, y 180cm de alcance
2. Combatiente 2: 1 victoria, zurdo y 175cm de alcance

Haríamos la siguiente consulta:
```
6,Diestro,190,1,Zurdo,175,?
```
Y obtendríamos como resultado BLUE, lo que significa que ganaría el primer combatiente.
