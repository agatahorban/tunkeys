//var photos = new Array();
//var text = new Array();
//var which = 0;
//var what = 0;
//
////Change the below variables to reference your own images. You may have as many images in the slider as you wish
//photos[0] = "http://4.bp.blogspot.com/_KxguSWy5e5s/TFJL_iOVm3I/AAAAAAAAKdg/2hCERTjApog/s400/alice_in_chains_-_mtv_unplugged_-_front.jpg";
//photos[1] = "http://www.ledotakas.net/image/cache/data/A/ALICE-IN-CHAINS-Black-Gives-Way-To-Blue-CD-400x400.jpg";
////change coresponding description
//text[0] = "B2 Stealth Bomber";
//text[1] = "F15 Tom Cat!";
//
//
window.onload = new Function("document.rotater.description.value=text[0]");

var which = 0;
var what = 0;

function backward() {
    if (which > 0) {
        
        window.status = '';
        which--;
        document.images.photoslider.src = photos[which];
        what--;
        document.rotater.description.value = text[what];
    }
}

function forward() {
    if (which < photos.length - 1) {
        which++;
        document.images.photoslider.src = photos[which];
        what++;
        document.rotater.description.value = text[what];
        document.getElementById("curbndd").textContent = text[what];
        alert(what);
    }
}

function type()
{
    alert("This textbox will only display default comments");
}