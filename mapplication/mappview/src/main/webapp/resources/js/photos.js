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
//window.onload = new Function("document.rotater.description.value=text[0]");
//
//function backward() {
//    if (which > 0) {
//        window.status = '';
//        which--;
//        document.images.photoslider.src = photos[which];
//        what--;
//        document.rotater.description.value = text[what];
//    }
//}
//
//function forward() {
//    if (which < photos.length - 1) {
//        which++;
//        document.images.photoslider.src = photos[which];
//        what++;
//        document.rotater.description.value = text[what];
//    }
//    else
//        window.status = 'End of gallery';
//}
//
//function type()
//{
//    alert("This textbox will only display default comments");
//}


function changeStar(x) {
    x.src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
}

function changeStarToNormal(x) {
    x.src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
}

function changeTwoStars(x) {
    x.src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star1").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
}

function changeTwoStarsToNormal(x) {
    x.src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star1").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
}

function changeThreeStars(x) {
    x.src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star1").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star2").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
}

function changeThreeStarsToNormal(x) {
    x.src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star1").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star2").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
}

function changeFourStars(x) {
    x.src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star1").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star2").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star3").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
}

function changeFourStarsToNormal(x) {
    x.src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star1").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star2").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star3").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
}

function changeFiveStars(x) {
    x.src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star1").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star2").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star3").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
    document.getElementById("star4").src="/mappview/javax.faces.resource/img/star2_small.png.xhtml";
}

function changeFiveStarsToNormal(x) {
    x.src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star1").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star2").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star3").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
    document.getElementById("star4").src="/mappview/javax.faces.resource/img/star1_small.png.xhtml";
}


function changeStarSmall(x) {
    x.src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
}

function changeStarToNormalSmall(x) {
    x.src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
}

function changeTwoStarsSmall(x,id1) {
    x.src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id1).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
}

function changeTwoStarsToNormalSmall(x,id1) {
    x.src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id1).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
}

function changeThreeStarsSmall(x,id1,id2) {
    x.src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id1).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id2).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
}

function changeThreeStarsToNormalSmall(x,id1,id2) {
    x.src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id1).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id2).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
}

function changeFourStarsSmall(x,id1,id2,id3) {
    x.src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id1).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id2).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id3).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
}

function changeFourStarsToNormalSmall(x,id1,id2,id3) {
    x.src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id1).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id2).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id3).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
}

function changeFiveStarsSmall(x,id1,id2,id3,id4) {
    x.src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id1).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id2).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id3).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
    document.getElementById(id4).src="/mappview/javax.faces.resource/img/star2_verysmall.png.xhtml";
}

function changeFiveStarsToNormalSmall(x,id1,id2,id3,id4) {
    x.src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id1).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id2).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id3).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
    document.getElementById(id4).src="/mappview/javax.faces.resource/img/star1_verysmall.png.xhtml";
}