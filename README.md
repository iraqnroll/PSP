# Programų sistemų projektavimo laboratoriniai darbai

- **Ar buvo aiškūs ir patogūs unti testai, ar kodas aiškus ?**
  * Unit testai buvo buvo dalinai patogūs, kai kuriuose validatorių testų klasėse nebuvo pakankamai gerai pagalvota apie implementaciją, todėl kai kurių laukų/objektų incializavimas buvo nepatogus.
- **Kaip galėtumėte juos pagerinti ?**
  * Daugiau dėmesio skirčiau pamastymui kaip šie validatoriai bus implementuoti ateityje ir sugalvoti patogesnį būda inicializuoti juos, paruošti jiems reikiamus duomenis.
- **Kokius unit testus jūs galėtumėte pridėti ?**
  * Email validatoriuje atskirčiau testavima neleistinų simbolių atskirai lokaliai ir domeno daliai, nes jiems taikomi skirtingi simbolių apribojimai. Taip pat nebuvo pagalvota apie duplikuojančius simbolius (@ , . ir tt)
