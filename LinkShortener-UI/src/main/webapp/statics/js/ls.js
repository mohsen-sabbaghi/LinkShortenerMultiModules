//  function setCustomValidity(){
//
// }
window.onload = function() {
    var today = new Date().toISOString().split('T')[0];
    document.getElementsByName("expired-date")[0].setAttribute('min', today);
};

