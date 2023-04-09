let mango = `Whip up this refreshing mango smoothie recipe for an instant energy boost! Each serving delivers nutrient-rich fruits, fiber, protein, and probiotics. This is a cool, refreshing, and creamy tropical-inspired drink.`;

let getTheBeets = `Beet juice may help lower your blood pressure.Parsley, apple, ginger, and lemon are all great foods full of nutrition. We’ve included cucumber in this beetroot juice recipe to help dilute the strong beet flavor, and to add a neutral balancing effect to the overall juice.`

let greenMachine = `Green juice is an extremely rich source of healthy fibers, vitamins, minerals,antioxidants, phytonutrients… the list goes on. It also contains active plant enzymes that your body needs.`

let pineGinger = `Pineapple is the source of bromelain,an anti-inflammatory proteolytic enzyme. Ginger (Zingiber officinale) is a natural cyclooxygenase inhibitor, and it has numerous other anti-inflammatory mechanisms.`

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

// Smoothie Objects
let smoothies = [
    {
        src: "img/orange.png",
        name: "Mango",
        benefit:"Stamina",
        view: stateObjs[0],
        link: "/collection/1",
        ingredients: mango,
        ingredientsList:`
                <li>Mango</li>
                <li>Coconut milk</li>
                <li>Protein Powder</li>
                <li>Papaya</li>
                <li>Bananas</li>
                <li>Orange juice</li>
            `
    },
    {
        src: "img/red.png",
        name: "Get the Beets",
        benefit:"Blood Pressure",
        view: stateObjs[1],
        link: "/collection/2",
        ingredients: getTheBeets,
        ingredientsList:`
                <li>Beets</li>
                <li>Parsley</li>
                <li>Ginger</li>
                <li>Lime</li>
                <li>Cucumber</li>
                <li>Apple</li>
            `
    },
    {
        src: "img/yellow.png",
        name: "Pine Ginger",
        benefit:"Detox",
        view: stateObjs[2],
        link: "/collection/3",
        ingredients: pineGinger,
        ingredientsList:`
                <li>Pineapple</li>
                <li>Ginger</li>
                <li>Apples</li>
                <li>Honey</li>
                <li>Lime Juice</li>
            `
    },
    {
        src: "img/green.png",
        name: "Green Machine",
        benefit:"Vitalize",
        view: stateObjs[3],
        link: "/collection/4",
        ingredients: greenMachine,
        ingredientsList:`
                <li>Kale</li>
                <li>Spinach</li>
                <li>Green Apples</li>
                <li>Cucumber</li>
                <li>Oranges</li>
            `
    },
]; // smoothies

