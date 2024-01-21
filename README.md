# Semestralní projekt: SmartHome
<<<<<<< README.md
=======

- Projekt SmartHome je simulace inteligentního domu. Program simuluje život lidí a zvířat, fungovaní zařízení.
- Implementované patterny: state (DeviceState), strategy (HouseStrategy), Singleton (SmartHouse) a Factory (DeviceFactory).

### F1:
Entity: Adult, Child, Animal, TV, AudioPlayer, CoffeeMachine, Fridge, Bicycle, Treadmill, Lamp, Computer, Room, Floor, House.

### F2:
Zařízení mají API. Akce z API jsou pouźitelné podle stavu zařízení. Stav je možný změnit pomocí API.

### F3:
Každé zařízení má vlastní spotřebu elektřiny. Když zařízení je vypnuto nebo rozbito, má spotřebu 0.

### F4:
U každého zařízení můžeme sebrat data o spotřebované elektřině.

### F5:
Osoby a zvířata náhodně provadějí akce, které mají efekt na jiných osob/zvířat nebo na zařízení.

### F6:
Každá osoba a každé zvíře se v každém okamžiku nachazejí v jedné místnosti a náhodně generují eventy.

### F7:
Eventy jsou přebírány a odbavovány vhodnou osobou.

### F8:
Na konci simulace program generuje reporty HouseConfigurationReport, EventReport, ActivityAndUsageReport a ConsumptionReport do složky src/main/reports.

### F9:
Při rozbití zařízení obyvatel domu prozkoumá dokumentaci k zařízení a provédé nápravnou akcí.

### F10:
Osoby v domě použivají jak sportovní, tak i jiná zařizení.

### Nefunkční požadavky:
- Není požadována autentizace ani autorizace
- Aplikace může běžet pouze v jedné JVM
- public metody mají JavaDoc.
- Reporty jsou generovány do textového souboru.
- Konfigurace domu, zařízení a obyvatel domu je nahrávána přímo z třídy.

### F2:
Zařízení mají API. Akce z API jsou pouźitelné podle stavu zařízení. Stav je možný změnit pomocí API.

### F3:
Každé zařízení má vlastní spotřebu elektřiny. Když zařízení je vypnuto nebo rozbito, má spotřebu 0.

### F4:
U každého zařízení můžeme sebrat data o spotřebované elektřině.

### F5:
Osoby a zvířata náhodně provadějí akce, které mají efekt na jiných osob/zvířat nebo na zařízení.

### F6:
Každá osoba a každé zvíře se v každém okamžiku nachazejí v jedné místnosti a náhodně generují eventy.

### F7:
Eventy jsou přebírány a odbavovány vhodnou osobou.

### F8:
Na konci simulace program generuje reporty HouseConfigurationReport, EventReport, ActivityAndUsageReport a ConsumptionReport do složky src/main/reports.

### F9:
Při rozbití zařízení obyvatel domu prozkoumá dokumentaci k zařízení a provédé nápravnou akcí.

### F10:
Osoby v domě použivají jak sportovní, tak i jiná zařizení.

### Nefunkční požadavky:
- Není požadována autentizace ani autorizace
- Aplikace může běžet pouze v jedné JVM
- public metody mají JavaDoc.
- Reporty jsou generovány do textového souboru.
- Konfigurace domu, zařízení a obyvatel domu je nahrávána přímo z třídy.
=======

>>>>>>> README.md
