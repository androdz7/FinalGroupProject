## Members
- Andro Dzamukashvili (ანდრო ძამუკაშვილი)
- Gega Gegetchkori (გეგა გეგეჭკორი)
- Irakli Jojua (ირაკლი ჯოჯუა)
- Nikoloz Qvatadze (ნიკოლოზ ქვათაძე)
- Vaniko Ghatchava (ვანიკო ღაჭავა)

---

## Test Cases

### UI
- **TC01** `testValidSignUp`: Andro Dzamukashvili
- **TC02** `testValidLogin`: Andro Dzamukashvili
- **TC03** `testInvalidLogin`: Andro Dzamukashvili
- **TC04** `testLogout`: Nikoloz Qvatadze
- **TC05** `testTestCasesPageLoads`: Nikoloz Qvatadze
- **TC06** `testInvalidSignUp`: Irakli Jojua
- **TC07** `testProductsDetails`: Irakli Jojua
- **TC08** `testHomePageSubscriptionMessage`: Vaniko Ghatchava
- **TC09** `testCartPageSubscriptionMessage`: Vaniko Ghatchava
- **TC10** `testAddProductsInCart`: Gega Gegetchkori


### API
- **TC01** `testGetAllProducts`: Gega Gegetchkori
- **TC02** `testPostAllProducts`: Gega Gegetchkori
- **TC03** `testGetAllBrands`: Vaniko Ghatchava
- **TC04** `testPutAllBrands`: Vaniko Ghatchava
- **TC05** `testSearchProduct`: Irakli Jojua
- **TC06** `testSearchProductNoParam`: Irakli Jojua
- **TC07** `testVerifyLoginValid`: Nikoloz Qvatadze
- **TC08** `testVerifyLoginNoEmail`: Nikoloz Qvatadze
- **TC09** `testDeleteVerifyLogin`: Gega Gegetchkori
- **TC10** `testVerifyLoginInvalid`: Gega Gegetchkori

---

## Architecture
პროექტი იყენებს **Page Object Model (POM)** და **Service-Oriented** მიდგომას:

* **`pages`**: UI ელემენტები და მეთოდები.
* **`services`**: API ენდპოინტები და რექვესტები (ApiService).
* **`models`**: POJO კლასები JSON-ის დესერიალიზაციისთვის.
* **`utils`**: კონფიგურაციის წამკითხველი (ConfigReader).
* **`endpoints`**: API მარშრუტების (Routes) ცენტრალიზებული შენახვა.

---

## Execution Steps

პროექტის კლონირების შემდეგ მიჰყევით ამ ნაბიჯებს:

### Prerequisites
დარწმუნდით, რომ გაქვთ:
* **JDK 11** ან უფრო ახალი (რეკომენდებულია OpenJDK).
* **Maven** დაყენებული და დამატებული PATH-ში.
* **Allure** (ვიზუალური რეპორტებისთვის).

### Execution

* ტესტის გასაშვებათ უნდა შეასრულოთ ყველა ზემოთ მოცემული პირობა, ამის შემდგომ შეგიძლიათ გადახვიდეთ testing.xml ფაილში და IDE-დან გაუშვათ ტესტი.
* ან თუ maven არის დაყენებული თქვენს კომპიუტერში შეგიძლიათ გამოიყენოთ command: mvn clean test, 
* რომელიც ასევე განაპირობებს რომ allure-results-ში ყველა გაშვებაზე ახალი მონაცემები გაჩნდება და ძველი წაიშლება
* Allure-ის გამოსაყენებლად, ტესტის დამთავრების შემდეგ გამოიყენეთ კონსოლი და კომანდი: allure serve target/allure-results