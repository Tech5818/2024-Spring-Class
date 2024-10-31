const pageAfterLoaded = () => {
    // ElementVariable
    const ListBox = document.querySelector(".list-box")

    const SearchInput = document.getElementById("search-hamburger")


    // globalVariable

    const getHamburgerMenus = async (searchMenu = "") => {
        searchMenu = encodeURIComponent(searchMenu)

        const url = `lotteria-menus?hamburgerName=${searchMenu}`
        console.log(url)
        hamburgerMenus =
            await fetch(url)
                .then(data => data.json());

        return hamburgerMenus
    }

    const createElement = (element) => {
        return document.createElement(element)
    }

    const setClassName = (element, classNames) => {
        classNames.forEach(className => {
            element.classList.add(className)
        })
    }

    const createHamburgerBox = (src, name, price) => {
        // CreateElement
        const HamburgerBox = createElement("div")
        const HamburgerImage = createElement("img")
        const HamburgerName = createElement("p")
        const HamburgerPrice = createElement("p")

        // Defiend ClassName
        setClassName(HamburgerBox, ['hamburger-box']);
        setClassName(HamburgerImage, ['hamburger-image'])
        setClassName(HamburgerName, ["hamburger-data", "hamburger-name"])
        setClassName(HamburgerPrice, ["hamburger-data", "hamburger-price"])

        // SetAttribute
        HamburgerImage.setAttribute('alt', name);
        HamburgerImage.setAttribute('src', src);

        // SetText
        HamburgerName.textContent = name;
        HamburgerPrice.textContent = `${price}원`;

        // AssemblyElement
        HamburgerBox.append(HamburgerImage)
        HamburgerBox.append(HamburgerName)
        HamburgerBox.append(HamburgerPrice)

        return HamburgerBox
    }

    const painMenus = async (searchMenu = "") => {
        const hamburgerMenus =  await getHamburgerMenus(searchMenu);

        ListBox.innerHTML = ''

        hamburgerMenus.forEach(hamburgerMenu => {
            const menu = createHamburgerBox(hamburgerMenu.imagePath, hamburgerMenu.name, hamburgerMenu.price)
            ListBox.appendChild(menu)
        })
    }
    painMenus()


    SearchInput.addEventListener("input", (e) => {
        const searchText = e.target.value;

        painMenus(searchText)
    })
}


window.addEventListener('DOMContentLoaded', pageAfterLoaded);

