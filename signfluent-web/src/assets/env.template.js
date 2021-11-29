(function(window) {
  window.env = window.env || {};

  // Environment variables
  window["env"]["apiHost"] = "${BUSINESS_SERVICE_SVC_SERVICE_HOST}";
  window["env"]["apiPort"] = "${BUSINESS_SERVICE_SVC_SERVICE_PORT}";
})(this);
