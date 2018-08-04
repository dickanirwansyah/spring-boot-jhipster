angular.module('crudApp').factory('Departement', Departement);

Departement.$inject = ['$resource'];

function Departement($resource){
    var resourceUrl = 'api/departement/:id';

    return $resource(resourceUrl, {}, {
        'update' : {
            method : 'PUT'
        }
    });
}