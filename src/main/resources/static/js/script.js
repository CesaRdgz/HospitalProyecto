function initMap(){
    var coordenadas = {lat: 40.421932 ,lng: -3.616656};
    var map = new google.maps.Map(document.getElementById('map'),{
      zoom: 10,
      center: coordenadas
    });
    var marker = new google.maps.Marker({
      position: coordenadas,
      map: map
    });
}
