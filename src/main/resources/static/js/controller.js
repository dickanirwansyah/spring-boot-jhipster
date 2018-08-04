angular.module('crudApp').controller('GeneralController', GeneralController);

GeneralController.inject = ['$scope', 'Employee', 'Departement'];

function GeneralController($scope, Employee, Departement){

    $scope.employees = Employee.query();

    $scope.departements = Departement.query();

    $scope.employee = {};

    $scope.departement = {};

    $scope.saveEmployee = function(){
        //check id jika tidak kosong
        if ($scope.employee.id !== undefined){
            Employee.update($scope.employee, function(){
                $scope.employees = Employee.query();
                $scope.employee = {};
            });
        }else {
            Employee.save($scope.employee, function(){
                $scope.employees = Employee.query();
                $scope.employee = {};
            });
        }
    }

    $scope.updateEmployeeInit = function(employee){
        $scope.employee = employee;
    }

    $scope.deleteEmployee = function(employee){
        employee.$delete({id: employee.id}, function(){
            $scope.employees = Employee.query();
            $scope.employee = {};
        });
    }

    $scope.saveDepartement = function(){
        //check id
        if ($scope.departement.id !== undefined){
            Departement.update($scope.departement, function(){
                $scope.departements = Departement.query();
                $scope.departement = {};
            });
        }else{
            Departement.save($scope.departement, function(){
                $scope.departements = Departement.query();
                $scope.departement = {};
            });
        }
    }

    $scope.updateDepartementInit = function(departement){
        $scope.departement = departement;
    }
}