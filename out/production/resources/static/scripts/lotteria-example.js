const pageAfterLoaded = () => {
    // ElementVariable
    const ListBox = document.querySelector(".list-box")

    const SearchInput = document.getElementById("search-hamburger")

    const OpenAddMenuModal = document.getElementById("open-add-menu-modal")

    const CloseAddMenuModal = document.getElementById("close-modal")

    const ModalBox = document.querySelector("dialog")

    // globalVariable

    const getHamburgerMenus = async (searchMenu = "") => {
        searchMenu = encodeURIComponent(searchMenu)

        const url = `lotteria-menus?hamburgerName=${searchMenu}`

        hamburgerMenus =
            await fetch(url)
                .then(data => data.json());

        return hamburgerMenus
    }

    const deleteHamburgerMenu = async (hamburgerName) => {
        // hamburgerName = encodeURIComponent(hamburgerName)

        const url = `lotteria-delete-menu?hamburgerName=${hamburgerName}`

        deleteHamburger = await  fetch(url, {method: "delete"}).then(data => data.json())

        return deleteHamburger;
    }

    const createElement = (element, classNames = []) => {
        const returnElement = document.createElement(element)
        setClassName(returnElement, classNames)
        return returnElement
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
        const HamburgerInfoBox = createElement("div")
        const HamburgerNamePriceBox = createElement("div")
        const HamburgerName = createElement("p")
        const HamburgerPrice = createElement("p")
        const TrashBox = createElement("div", ["trash-box"])
        const Trash = createElement("div", ["trash"])
        const TrashTop = createElement("div", ["trash-top"])
        const TrashBottom = createElement("div", ["trash-btm"])
        const TrashLines = createElement("div", ["trash-lines"])
        const TrashLine1 = createElement("div", ["trash-line"])
        const TrashLine2 = createElement("div", ["trash-line"])

        // Defiend ClassName
        setClassName(HamburgerBox, ['hamburger-box']);
        setClassName(HamburgerImage, ['hamburger-image'])
        setClassName(HamburgerInfoBox, ["hamburger-info-box"])
        setClassName(HamburgerNamePriceBox, ["hamburger-name-price-box"])
        setClassName(HamburgerName, ["hamburger-data", "hamburger-name"])
        setClassName(HamburgerPrice, ["hamburger-data", "hamburger-price"])

        // SetAttribute
        HamburgerImage.setAttribute('alt', name);
        HamburgerImage.setAttribute('src', src);

        // SetText
        HamburgerName.textContent = name;
        HamburgerPrice.textContent = `${price}원`;

        // AssemblyElement
        TrashLines.append(TrashLine1)
        TrashLines.append(TrashLine2)
        TrashBottom.append(TrashLines)
        TrashBox.append(Trash)
        TrashBox.append(TrashTop)
        TrashBox.append(TrashBottom)

        TrashBox.addEventListener("click", (e) => {

            deleteHamburgerMenu(name);
            alert(name)
            painMenus()
        })

        HamburgerBox.append(HamburgerImage)
        HamburgerNamePriceBox.append(HamburgerName)
        HamburgerNamePriceBox.append(HamburgerPrice)
        HamburgerInfoBox.append(HamburgerNamePriceBox)
        HamburgerInfoBox.append(TrashBox)
        HamburgerBox.append(HamburgerInfoBox)




        return HamburgerBox
    }

     async function painMenus(searchMenu = "")  {
        const hamburgerMenus =  await getHamburgerMenus(searchMenu);

        ListBox.replaceChildren()

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

    OpenAddMenuModal.addEventListener("click", () => {
        ModalBox.showModal()
    })

    CloseAddMenuModal.addEventListener("click", () => {
        ModalBox.close()
    })

    ModalBox.addEventListener("click", () => {
        ModalBox.close()
    }, false)

    document.querySelector(".modal-container").addEventListener("click", e => {
        e.stopImmediatePropagation()
    })


}


window.addEventListener('DOMContentLoaded', pageAfterLoaded);

