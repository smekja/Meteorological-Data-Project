<p align="center">
  <img src="https://engeto.cz/wp-content/uploads/2019/01/engeto-square.png" width="200" height="200">
</p>

# Java 2 - 4. lekce - Projekt

## Projekt
### Zadání

Nastal čas, abychom si ověřili rozsah tvých nově nabytých znalostí v oblasti základů programování v Javě. A to se vždy nejlépe pozná na reálném problému, před který je člověk postaven.

V rámci tohoto projektu vytvoříš aplikaci, která bude statisticky vyhodnocovat meteorologická data sbíraná a poskytovaná Českým hydrometeorologickým ústavem.

Abychom ti úkol trochu usnadnili, připravili jsme pro tebe vzorek takových dat.

Jedná se o data sebraná meteorologickou stanicí Brno - Tuřany (B2BTUR01) v červenci r. 2019. Vlastní data jsou v rámci šablony projektu uložena ve formě pole textových řetězců, kdy každý řetězec obsahuje údaje pro jeden kalendářní den.

Struktura jednoho záznamu je následující (oddělovačem každé položky je čárka):

```
<rok>,<měsíc>,<den>,<průměrná teplota>,<maximální teplota>,<minimální teplota>,<atmosférický tlak>,<rychlost větru>,<vlhkost vzduchu>,<úhrn srážek>
```

Tvůj program by měl provést následující kroky:

A. Přivítat uživatele výpisem na standardní výstup:
```
--------------------------------------------------------------------------------
Welcome to the application for Meteorological Data Analysis.
```

B. Vypsat na standardní výstup sadu statistických údajů v následujícím rozsahu:
-  celkový počet denních záznamů, které se budou vyhodnocovat
- průměrnou denní teplotu za sledované období
- maximální teplotu za sledované období s tím, že uvedete maximální teplotu a den, ve kterém bylo toto maximum zjištěno
- stejně tak pro vyhledání minimální teploty za uvedené období včetně uvedení dne
- celkový počet větrných dnů za dané období (za větrný den je považován ten, kdy průměrná denní rychlost větru je větší nebo rovna 4,2 m/s)
- celkový počet klidných dnů za dané období (za klidný den je považován ten, kdy průměrná denní rychlost větru je menší nebo rovna 1,8 m/s)
- souhrnný přehled srážek za sledované období v rozdělení do měsíčních dekád (jedná se nám tedy o úhrny srážek za prvních deset kalendářních dnů, za druhých deset kalendářních dnů, následuje pak úhrn srážek za všechny další dny)

Tady je příklad očekávaného výstupu:
```
--------------------------------------------------------------------------------
We have 31 meteorological daily records to analyze.
Average temperature for the reporting period: 21.3°C
Maximum temperature for the reporting period: 2019-07-01 was 35.4°C
Minimum temperature for the reporting period: 2019-07-11 was 8.7°C
Number of windy days: 3
Number of calm days : 2
Precipitation summary in month decades: 19.6mm - 28.5mm - 12.6mm
--------------------------------------------------------------------------------
```

Všechny vypočtené hodnoty uvádějte v přesnosti na jedno desetinné místo včetně odpovídajících jednotek.

C. Vypsat na standardní výstup graf rozložení denních teplot.
Jedná se nám o graf, ve kterém:

- jednotlivé řádky budou zobrazovat kalendářní dny
- v každém řádku bude vyznačen rozsah minimální a maximální teploty znakem *
- graf bude doplněn o osy

Očekávaný výstup je následující:
```
--------------------------------------------------------------------------------
   | 00--------10--------20--------30--------40
01 |                    *****************
02 |                  ***********
03 |                **********
04 |              **************
05 |             ****************
06 |            ***********************
07 |                 ***********
08 |             ***********
09 |              **********
10 |              *********
11 |          ******************
12 |              ********
13 |              ********
14 |                *********
15 |              ***********
16 |             *************
17 |            ***************
18 |              ***************
19 |               ***************
20 |                 ****************
21 |                   ************
22 |                 ***************
23 |                     ************
24 |                  *****************
25 |                   *****************
26 |                   *****************
27 |                    *********
28 |                   ************
29 |                    *************
30 |                   ************
31 |                     **********
   | 00--------10--------20--------30--------40
--------------------------------------------------------------------------------
```
