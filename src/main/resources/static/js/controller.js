app.controller('usersController', function($scope) {
	$scope.headingTitle = "Employee Section";
	$scope.objectIndex = '';
	$scope.userList = [
	                   {

	                	   Name: 'Parvez Alam',
	                	   Age: '28',
	                	   id : 1
	                   },

	                   {
	                	   Name: 'Sameer',
	                	   Age: '13',
	                	   id : 2
	                   },
	                   {
	                	   Name: 'Rakesh',
	                	   Age: '55',
	                	   id : 3
	                   },
	                   {
	                	   Name: 'Ramesh',
	                	   Age: '44',
	                	   id : 4
	                   },
	                   {
	                	   Name: 'Aman',
	                	   Age: '34',
	                	   id : 5
	                   },
	                   {
	                	   Name: 'John',
	                	   Age: '23',
	                	   id : 6
	                   }
	                   ];

	$scope.edit = function(id) {
		//search user and update it
		$scope.objectIndex = id;
		$scope.userObject = angular.copy($scope.userList[id]);
		console.log($scope.objectIndex);
	}

	$scope.save = function() {
		if($scope.userList[$scope.objectIndex] == null) {
			//if this is new record, add it in users array
			$scope.userList.push($scope.userObject);
		} else {
			//for existing record, find this record using id
			//and update it.
			$scope.userList[$scope.objectIndex] = $scope.userObject;
		}

		//clear the add record form
		$scope.userObject = {};
		$scope.objectIndex = '';
	}

	$scope.del = function(id) {
		//search record with given id and delete it
		for(i in $scope.userList) {
			if($scope.userList[i].id == id) {
				$scope.userList.splice(i,1);
			}
		}

	}
});

