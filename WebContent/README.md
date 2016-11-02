# Website

To run the website locally you should have installed updated versions of `nodeJS` and `npm` from https://nodejs.org/

    $ git clone http://github.com/kant003/Store.git
    $ cd WebContent/
    $ npm install
    $ npm run local

Open http://localhost:8080/ on your browser and you're good to go.

To deploy to surge. You need to install surge globally. In the same directory:


    $ sudo npm install -g surge
    $ npm run deploy

This will deploy a version of the website to surge CI platform on

## http://cebem-store.surge.sh/
