# Website

To run the website locally you should have installed updated versions of `nodeJS` and `npm` from https://nodejs.org/

    $ git clone http://github.com/kant003/Store.git
    $ cd WebContent/
    $ npm install
    $ npm run local

Open http://localhost:8080/ on your browser and you're good to go.

For production deployment on surge CI tool, you need to install surge globally. Type in the same directory:

    $ sudo npm install -g surge
    $ npm run deploy

This will deploy a version of the website to surge CI platform on

## http://cebem-store.surge.sh/


____

## npm dependencies


#### devDependencies


* **"connect"**: "^3.5.0"

  Serves content.

* **"serve-static"**: "^1.11.1"

  Serves static content.

* **"css-loader"**: "^0.25.0"

  CSS loader for webpack

* **"exports-loader"**: "^0.6.3"

  exports loader for webpack

* **"file-loader"**: "^0.9.0"

  File loader for webpack

* **"font-awesome"**: "^4.7.0"

  Font Awesome for Bootstrap

* **"imports-loader"**: "^0.6.5"

  Imports loader for webpack

* **"less-loader"**: "^2.2.3"

  less loader for webpack

* **"style-loader"**: "^0.13.1"

  Stylesheets loader for webpack

* **"url-loader"**: "^0.5.7"

  URL loader for webpack

* **"extract-text-webpack-plugin"**: "^1.0.1"

  extract text loader for webpack

* **"webpack"**: "^1.13.3"

  Webpack / Module Bundler


#### dependencies


* **"alasql"**: "^0.3.3"

  SQL Database connector

* **"bootstrap"**: "^3.3.7"

  Bootstrap

* **"bootstrap-webpack"**: "0.0.5"

  Bootstrap webpack module

* **"font-awesome-webpack"**: "0.0.4"

  Font Awesome webpack module

* **"jquery"**: "^3.1.1"

  jQuery module

* **"less"**: "^2.7.1"

  less module

* **"normalizecss"**: "^3.0.0"

  normalizes css to standards

* **"surge"**: "0.18.0"

  Continuous Integration Platform
