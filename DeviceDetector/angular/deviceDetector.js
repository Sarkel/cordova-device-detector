/**
 * Created by Sebastian Kubalski on 12.04.2016.
 */
angular.module('DeviceDetector', [])
  .service('DeviceDetectorService', ['$q', function ($q) {
    this.isTablet = function () {
      var deferred = $q.defer();
      if (window.cordova) {
        cordova.plugins.DeviceDetector.isTablet(
          function (success) {
            deferred.resolve(success.isTablet)
          }, function (err) {
            deferred.reject(err);
          }
        );
      } else {
        deferred.reject(new Error());
      }
      return deferred.promise;
    };
  }]);
