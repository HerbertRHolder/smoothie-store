(function () {
    "use strict";
    // +++++++++++++ Nutrition Information ++++++++++++++++++++++
    let smoothieName = document.getElementById("smoothie-name");
    let smoothieBenefit = document.getElementById("smoothie-benefit");
    let benefitInfo = document.getElementById("benefit-info");
    let ingredientItems = document.getElementById("ingredients-items");
    // ++++++++++++++++++++++++++++++++++++++++++++++++++++

    let prev = document.getElementById("arrowL");
    let next = document.getElementById("arrowR");
    let currImg = document.getElementById("currImg");
    let breadCrumb = document.getElementById("product-crumb");
    let featureProduct = document.getElementById("anchor");
    console.log(featureProduct)
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



    let smoothies = [
        {
            src: "img/orange.png",
            name: "Mango",
            view: stateObjs[0],
            link: "/collection/1",
            ingredients: mango


        },
        {
            src: "img/red.png",
            name: "Get the Beets",
            view: stateObjs[1],
            link: "/collection/2",
            ingredients: getTheBeets
        },
        {
            src: "img/yellow.png",
            name: "Pine Ginger",
            view: stateObjs[2],
            link: "/collection/3",
            ingredients: pineGinger
        },
        {
            src: "img/green.png",
            name: "Green Machine",
            view: stateObjs[3],
            link: "/collection/4",
            ingredients: greenMachine
        },
    ]; // smoothieImgs
    breadCrumb.setAttribute("href", "/collection/1");
    breadCrumb.innerText = `${smoothies[0].name}`;

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
            index = smoothies.length - 1;
            smoothies[0].view.element.classList.remove("solidImg");
        } else {
            smoothies[index + 1].view.element.classList.remove("solidImg");
        }
        currImg.setAttribute("src", `${smoothies[index].src}`);
        breadCrumb.setAttribute("href", `${smoothies[index].link}`)
        featureProduct.setAttribute("href", `${smoothies[index].link}`)
        breadCrumb.innerText = `${smoothies[index].name}`;
        benefitInfo.innerText = `${smoothies[index].ingredients}`
        smoothies[index].view.element.classList.add("solidImg");
    }); // prev listener

    next.addEventListener("click", () => {
        index += 1;
        if (index > smoothies.length - 1) {
            index = 0;
            smoothies[smoothies.length - 1].view.element.classList.remove(
                "solidImg"
            );
        } else {
            smoothies[index - 1].view.element.classList.remove("solidImg");
        }
        console.log("next index: ", index);
        currImg.setAttribute("src", `${smoothies[index].src}`);
        breadCrumb.setAttribute("href", `${smoothies[index].link}`)
        benefitInfo.innerText = `${smoothies[index].ingredients}`
        featureProduct.setAttribute("href", `${smoothies[index].link}`);
        breadCrumb.innerText = `${smoothies[index].name}`;
        smoothies[index].view.element.classList.add("solidImg");
    }); // next listener
})();
