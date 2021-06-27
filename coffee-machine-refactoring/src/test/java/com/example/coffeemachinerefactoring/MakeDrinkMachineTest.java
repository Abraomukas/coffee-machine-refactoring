package com.example.coffeemachinerefactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MakeDrinkMachineTest {

    private MakeDrinkMachine underTest;

    @BeforeEach
    void setUp() {
        underTest = new MakeDrinkMachine();
    }

    @Test
    void itShouldOrder_CoffeeWithOneExtraSugarCube() {
        //given
        underTest.validateDrinkType("coffee");
        underTest.validaTePrice(1);
        underTest.validateExtraSugar(1);
        String expected = "You have ordered a coffee with 1 extra sugar cubes (stick included).";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_ExtraHotCoffeeWithOneExtraSugarCube() {
        //given
        underTest.validateDrinkType("coffee");
        underTest.validaTePrice(1);
        underTest.validateExtraSugar(1);
        underTest.makeDrinkExtraHot();
        String expected = "You have ordered a coffee with 1 extra sugar cubes (stick included). Extra hot.";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_Coffee() {
        //given
        underTest.validateDrinkType("coffee");
        underTest.validaTePrice(1);
        String expected = "You have ordered a coffee";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_CoffeeWithInsufficientMoney() {
        //given
        underTest.validateDrinkType("coffee");
        underTest.validaTePrice(0.1);
        underTest.validateExtraSugar(1);
        String expected = "The coffee costs 0.5.";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_TeaWithOneExtraSugarCube() {
        //given
        underTest.validateDrinkType("tea");
        underTest.validaTePrice(1);
        underTest.validateExtraSugar(1);
        String expected = "You have ordered a tea with 1 extra sugar cubes (stick included).";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_ExtraHotTeaWithOneExtraSugarCube() {
        //given
        underTest.validateDrinkType("tea");
        underTest.validaTePrice(1);
        underTest.validateExtraSugar(1);
        underTest.makeDrinkExtraHot();
        String expected = "You have ordered a tea with 1 extra sugar cubes (stick included). Extra hot.";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_Tea() {
        //given
        underTest.validateDrinkType("tea");
        underTest.validaTePrice(1);
        String expected = "You have ordered a tea";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_TeaWithInsufficientMoney() {
        //given
        underTest.validateDrinkType("tea");
        underTest.validaTePrice(0.1);
        underTest.validateExtraSugar(1);
        String expected = "The tea costs 0.4.";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_ChocolateWithOneExtraSugarCube() {
        //given
        underTest.validateDrinkType("chocolate");
        underTest.validaTePrice(1);
        underTest.validateExtraSugar(1);
        String expected = "You have ordered a chocolate with 1 extra sugar cubes (stick included).";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_ExtraHotChocolateWithOneExtraSugarCube() {
        //given
        underTest.validateDrinkType("chocolate");
        underTest.validaTePrice(1);
        underTest.validateExtraSugar(1);
        underTest.makeDrinkExtraHot();
        String expected = "You have ordered a chocolate with 1 extra sugar cubes (stick included). Extra hot.";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_Chocolate() {
        //given
        underTest.validateDrinkType("chocolate");
        underTest.validaTePrice(1);
        String expected = "You have ordered a chocolate";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldOrder_ChocolateWithInsufficientMoney() {
        //given
        underTest.validateDrinkType("chocolate");
        underTest.validaTePrice(0.1);
        underTest.validateExtraSugar(1);
        String expected = "The chocolate costs 0.6.";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void itShouldNotOrder() {
        //given
        underTest.validateDrinkType("foo");
        underTest.validaTePrice(0.1);
        underTest.validateExtraSugar(1);
        String expected = "The drink type should be tea, coffee or chocolate.";

        //when
        underTest.showOrder();

        //
        String result = underTest.getMessage();
        assertThat(result).isEqualTo(expected);
    }
}