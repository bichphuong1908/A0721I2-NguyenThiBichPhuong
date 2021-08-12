let part1 = document.getElementById("part1");
let part2 = document.getElementById("part2");
let part3 = document.getElementById("part3");
let part4 = document.getElementById("part4");
let part5 = document.getElementById("part5");

function change(part) {
    let get_img = document.getElementById(`${part}`);
    // let id = get_img.getAttribute('id');
    // console.log(id);
    switch (part) {
        case 'part1':
            if (get_img.getAttribute('src') === 'img/funny-cat1_part1x1.jpg') {
                get_img.src = 'img/monkey_part1x1.jpg';
            } else if (get_img.getAttribute('src') === 'img/monkey_part1x1.jpg') {
                get_img.src = 'img/panda_swap_part1x1.jpg';
            } else {
                get_img.src = 'img/funny-cat1_part1x1.jpg';
            }
            break;
        case 'part2':
            if (get_img.getAttribute('src') === 'img/funny-cat1_part2x1.jpg') {
                get_img.src = 'img/monkey_part2x1.jpg';
            } else if (get_img.getAttribute('src') === 'img/monkey_part2x1.jpg') {
                get_img.src = 'img/panda_swap_part2x1.jpg';
            } else {
                get_img.src = 'img/funny-cat1_part2x1.jpg';
            }
            break;
        case 'part3':
            if (get_img.getAttribute('src') === 'img/funny-cat1_part3x1.jpg') {
                get_img.src = 'img/monkey_part3x1.jpg';
            } else if (get_img.getAttribute('src') === 'img/monkey_part3x1.jpg') {
                get_img.src = 'img/panda_swap_part3x1.jpg';
            } else {
                get_img.src = 'img/funny-cat1_part3x1.jpg';
            }
            break;
        case 'part4':
            if (get_img.getAttribute('src') === 'img/funny-cat1_part4x1.jpg') {
                get_img.src = 'img/monkey_part4x1.jpg';
            } else if (get_img.getAttribute('src') === 'img/monkey_part4x1.jpg') {
                get_img.src = 'img/panda_swap_part4x1.jpg';
            } else {
                get_img.src = 'img/funny-cat1_part4x1.jpg';
            }
            break;
        case 'part5':
            if (get_img.getAttribute('src') === 'img/funny-cat1_part5x1.jpg') {
                get_img.src = 'img/monkey_part5x1.jpg';
            } else if (get_img.getAttribute('src') === 'img/monkey_part5x1.jpg') {
                get_img.src = 'img/panda_swap_part5x1.jpg';
            } else {
                get_img.src = 'img/funny-cat1_part5x1.jpg';
            }
            break;
    }
    checkImage();
}
function checkImage(){
    if (part1.getAttribute('src') === 'img/funny-cat1_part1x1.jpg' &&
        part2.getAttribute('src') === 'img/funny-cat1_part2x1.jpg' &&
            part3.getAttribute('src') === 'img/funny-cat1_part3x1.jpg' &&
                part4.getAttribute('src') === 'img/funny-cat1_part4x1.jpg' &&
                    part5.getAttribute('src') === 'img/funny-cat1_part5x1.jpg'){
                alert('Đây chính xác là hình con mèo rồi!');
        document.getElementById("puzzle").style.boxShadow = '0 0 3px 3px green';
    }
    if (part1.getAttribute('src') === 'img/monkey_part1x1.jpg' &&
        part2.getAttribute('src') === 'img/monkey_part2x1.jpg' &&
        part3.getAttribute('src') === 'img/monkey_part3x1.jpg' &&
        part4.getAttribute('src') === 'img/monkey_part4x1.jpg' &&
        part5.getAttribute('src') === 'img/monkey_part5x1.jpg'){
        alert('Đây chính xác là hình con khỉ rồi!');
        document.getElementById("puzzle").style.boxShadow = '0 0 3px 3px green';
    }
    if (part1.getAttribute('src') === 'img/panda_swap_part1x1.jpg' &&
        part2.getAttribute('src') === 'img/panda_swap_part2x1.jpg' &&
        part3.getAttribute('src') === 'img/panda_swap_part3x1.jpg' &&
        part4.getAttribute('src') === 'img/panda_swap_part4x1.jpg' &&
        part5.getAttribute('src') === 'img/panda_swap_part5x1.jpg'){
        alert('Đây chính xác là hình con gấu trúc rồi!');
        document.getElementById("puzzle").style.boxShadow = '0 0 3px 3px green';
    }
}

