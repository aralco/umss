# umss
This repository is for including university projects.


Se pide modelar e implementar un programa que ayude a un Regimiento militar a poder administrar todos los activos con que cuenta, ya que el numero de soldados e instructorres crecio considerablemente


El regimiento militar cuenta con diferentes instalaciones, pero como primera parte se pide implementar el programa para las siguientes instalaciones:

- Armerias
- Estacionamientos
- Almacen

siendo estos los puntos criticos donde mas frecuenta todo el Regimiento. Cada uno de estos puntos criticos( instalaciones ), se encuentran situados en diferentes lugares del Regimiento

Sobre la Armeria.-

En este establecimiento se encuentra almacenada todo el material belico del regimiento, siendo un lugar de suma importacia, para la cual se pide al programa que sea capaz de llevar un inventario de todos las activos con que cuenta el mismo, siendo que este cuenta con una gran variada de armamento.

De las caracteristicas de cada tipo de arma podemos destacar las siguientes : 

- identificador
- modelo del arma
- tipo de municion
- descripcion breve
- proveedor

el programa tiene que ser capaz de dar el siguiente reporte :

- el numero total de armas
- numero de armas de un tipo especifico
- informacion sobre un arma especifica


Sobre el Estacionamientos

En este establecimiento se encuentra las diferente tipos de movilidades con que cuenta el Regimiento, como ser : tanques, autos, camiones y motocicletas, siendo que cada uno usa distintos tipo de combustible

y se pide que nos permite administrar lo siguiente :

- informacion sobre todos los activos del mismo

- numero de activos de este establecimiento
- numero de activos dependienteo el tipo

- cantidad de combustible  de cada tipo

- informacion de un vehiculo espefico

donde cada vehiculo cuenta con los siguientes datos:

- id vehiculo
- tipo de motor
- tipo de conbustible
- una descripcion del estado del mismo como ser fallas, si esque las cuenta
- proveedor

sobre Almacen.-

este es otro punto critico,puesto que el lugar donde se encuentra todas los productos alimenticios  del regimiento como ser harina, azucar, carne, etc

el programa tiene que ser capaz de llevar un inventario de cada una de estos prooductos como ser:

- informacion sobre el capital total de todos estos activos
- informacion sobre el capital de los productos de un tipo especifico
- informacion sobre un producto especfico

cada producto cuenta con la siguiente informacion:

- id producto
- nombre del producto
- fecha vencimiento
- descripcion breve
- proveedor


todos los activos del regimientos son dotados por el gobierno que es quien vela por el bienestar de las fuezas armadas
el programa tiene que ser capaz de emular la administracion del cacino, Armeria, Estacionamiento y suministracion de los activos

=======

# Estudiantes
  * a
  * a2
# Enunciado del problema
 Se tiene una organizacion militar que gestiona la seguridad de un determinado pais. Para llevar a cabo sus actividades la organizacion debe hacer una gestion de personal (militares), estaciones que pueden ser: armerias, proveedores de combustible, recintos de personal. Asimismo debe gestionar los activos de la organizacion, como ser armamento y vehiculos.

# Bosquejo y estrategia de solución
blabkabk
diagram

# Código fuente
blablabla

[![N|Solid](https://cldup.com/dTxpPi9lDf.thumb.png)](https://nodesource.com/products/nsolid)

Dillinger is a cloud-enabled, mobile-ready, offline-storage, AngularJS powered HTML5 Markdown editor.

  - Type some Markdown on the left
  - See HTML in the right
  - Magic

# New Features!

  - Import a HTML file and watch it magically convert to Markdown
  - Drag and drop images (requires your Dropbox account be linked)


You can also:
  - Import and save files from GitHub, Dropbox, Google Drive and One Drive
  - Drag and drop markdown and HTML files into Dillinger
  - Export documents as Markdown, HTML and PDF

Markdown is a lightweight markup language based on the formatting conventions that people naturally use in email.  As [John Gruber] writes on the [Markdown site][df1]

> The overriding design goal for Markdown's
> formatting syntax is to make it as readable
> as possible. The idea is that a
> Markdown-formatted document should be
> publishable as-is, as plain text, without
> looking like it's been marked up with tags
> or formatting instructions.

This text you see here is *actually* written in Markdown! To get a feel for Markdown's syntax, type some text into the left window and watch the results in the right.

### Tech

Dillinger uses a number of open source projects to work properly:

* [AngularJS] - HTML enhanced for web apps!
* [Ace Editor] - awesome web-based text editor
* [markdown-it] - Markdown parser done right. Fast and easy to extend.
* [Twitter Bootstrap] - great UI boilerplate for modern web apps
* [node.js] - evented I/O for the backend
* [Express] - fast node.js network app framework [@tjholowaychuk]
* [Gulp] - the streaming build system
* [Breakdance](http://breakdance.io) - HTML to Markdown converter
* [jQuery] - duh

And of course Dillinger itself is open source with a [public repository][dill]
 on GitHub.

### Installation

Dillinger requires [Node.js](https://nodejs.org/) v4+ to run.

Install the dependencies and devDependencies and start the server.

```sh
$ cd dillinger
$ npm install -d
$ node app
```

For production environments...

```sh
$ npm install --production
$ NODE_ENV=production node app
```

### Plugins

Dillinger is currently extended with the following plugins. Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| Github | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |


### Development

Want to contribute? Great!

Dillinger uses Gulp + Webpack for fast developing.
Make a change in your file and instantanously see your updates!

Open your favorite Terminal and run these commands.

First Tab:
```sh
$ node app
```

Second Tab:
```sh
$ gulp watch
```

(optional) Third:
```sh
$ karma test
```
#### Building for source
For production release:
```sh
$ gulp build --prod
```
Generating pre-built zip archives for distribution:
```sh
$ gulp build dist --prod
```
### Docker
Dillinger is very easy to install and deploy in a Docker container.

By default, the Docker will expose port 8080, so change this within the Dockerfile if necessary. When ready, simply use the Dockerfile to build the image.

```sh
cd dillinger
docker build -t joemccann/dillinger:${package.json.version}
```
This will create the dillinger image and pull in the necessary dependencies. Be sure to swap out `${package.json.version}` with the actual version of Dillinger.

Once done, run the Docker image and map the port to whatever you wish on your host. In this example, we simply map port 8000 of the host to port 8080 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 8000:8080 --restart="always" <youruser>/dillinger:${package.json.version}
```

Verify the deployment by navigating to your server address in your preferred browser.

```sh
127.0.0.1:8000
```

#### Kubernetes + Google Cloud

See [KUBERNETES.md](https://github.com/joemccann/dillinger/blob/master/KUBERNETES.md)


### Todos

 - Write MORE Tests
 - Add Night Mode

License
----

MIT


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>

