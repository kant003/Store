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

  Connect is a simple framework to glue together various "middleware" to handle requests.

  https://github.com/senchalabs/connect

* **"serve-static"**: "^1.11.1"

  Serves static content.
  Create a new middleware function to serve files from within a given root directory.

  https://github.com/expressjs/serve-static

* **"css-loader"**: "^0.25.0"

  CSS loader for webpack

  https://github.com/webpack/css-loader

* **"exports-loader"**: "^0.6.3"

  exports loader for webpack

  https://github.com/webpack/exports-loader

* **"file-loader"**: "^0.9.0"

  File loader for webpack

  https://github.com/webpack/file-loader

* **"font-awesome"**: "^4.7.0"

  Font Awesome for Bootstrap

  http://fontawesome.io/get-started/

* **"imports-loader"**: "^0.6.5"

  Imports loader for webpack

  https://github.com/webpack/imports-loader
* **"less-loader"**: "^2.2.3"

  less loader for webpack

  https://github.com/webpack/less-loader

* **"style-loader"**: "^0.13.1"

  Stylesheets loader for webpack

  https://github.com/webpack/styles-loader

* **"url-loader"**: "^0.5.7"

  URL loader for webpack

  https://github.com/webpack/url-loader

* **"extract-text-webpack-plugin"**: "^1.0.1"

  Extract text from bundle into a file

  https://github.com/webpack/extract-text-webpack-plugin

* **"webpack"**: "^1.13.3"

  Webpack / Module Bundler

  https://webpack.github.io/docs/

#### dependencies


* **"alasql"**: "^0.3.3"

  SQL Database connector

  https://github.com/agershun/alasql/wiki

* **"bootstrap"**: "^3.3.7"

  Bootstrap

  http://bootstrapdocs.com/

* **"bootstrap-webpack"**: "0.0.5"

  Bootstrap webpack module

  https://github.com/bline/bootstrap-webpack

* **"font-awesome-webpack"**: "0.0.4"

  Font Awesome webpack module

  https://github.com/gowravshekar/font-awesome-webpack

* **"jquery"**: "^3.1.1"

  jQuery module

  http://api.jquery.com/

* **"less"**: "^2.7.1"

  less language module for dynamic stylesheets

  https://www.npmjs.com/package/less

* **"normalizecss"**: "^3.0.0"

  normalizes css to standards

  https://necolas.github.io/normalize.css/

* **"surge"**: "0.18.0"

  Continuous Integration Platform

  https://surge.sh/help/
