(function () {
    "use strict";
    let prev = document.getElementById("arrowL");
    let next = document.getElementById("arrowR");
    let currImg = document.getElementById("currImg");
    let breadCrumb = document.getElementById("product-crumb");
    let index = 0;
    const images = document.querySelectorAll("[data-src]");
    const imgOptions = {};
    let products = document.querySelectorAll(".product-view");
    let firstBottle = products[0];
    firstBottle.classList.add("solidImg");

    products = Array.from(products);
    let stateObjs = [];
    for (let i = 0; i < products.length; i++) {
        let stateObj = {
            element: products[i],
            isSelected: false,
        };
        stateObjs.push(stateObj);
    }



    let smoothieImgs = [
        {
            src: "img/orange.png",
            name: "Yah Mongo",
            view: stateObjs[0],
            link: "/yah-mongo",
            ingredients: ""

        },
        {
            src: "img/red.png",
            name: "Get the Beets",
            view: stateObjs[1],
            link: "/Get-the-Beets",
            ingredients: ""
        },
        {
            src: "img/yellow.png",
            name: "Pine Ginger",
            view: stateObjs[2],
            link: "/pine-ginger",
            ingredients: ""
        },
        {
            src: "img/green.png",
            name: "Green Machine",
            view: stateObjs[3],
            link: "green-machine",
            ingredients: ""
        },
    ]; // smoothieImgs
    stateObjs.map((item) => {
        item.element.addEventListener("click", () => {
            // item.element.classList.add("solidImg");
            item.isSelected = true;
            console.log(stateObjs);
        });
    });// end of map

    if (images !== null) {
        const imgObserver = new IntersectionObserver((entrties, imgObserver) => {
            entrties.forEach((entry) => {
                if (!entry.isIntersecting) {
                    return;
                } else {
                    preloadImage;
                }
            });
        }, imgOptions);
    } // end of if


    prev.addEventListener("click", () => {
        index -= 1;

        if (index < 0) {
            index = smoothieImgs.length - 1;
            smoothieImgs[0].view.element.classList.remove("solidImg");
        } else {
            smoothieImgs[index + 1].view.element.classList.remove("solidImg");
        }
        currImg.setAttribute("src", `${smoothieImgs[index].src}`);
        smoothieImgs[index].view.element.classList.add("solidImg");
    }); // prev listener
    next.addEventListener("click", () => {
        index += 1;
        if (index > smoothieImgs.length - 1) {
            index = 0;
            smoothieImgs[smoothieImgs.length - 1].view.element.classList.remove(
                "solidImg"
            );
        } else {
            smoothieImgs[index - 1].view.element.classList.remove("solidImg");
        }
        console.log("next index: ", index);
        currImg.setAttribute("src", `${smoothieImgs[index].src}`);
        smoothieImgs[index].view.element.classList.add("solidImg");
    }); // next listener
})();
