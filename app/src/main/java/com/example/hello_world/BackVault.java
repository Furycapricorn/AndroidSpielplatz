package com.example.hello_world;

/**
 * Die Klasse Backvault kann genutzt werden um die Funktionalität des Zurück-Buttons
 * abzufragen oder zuverändern.
 *
 * @author Maximilian Hartmann
 *
 */
public class BackVault {

    private static boolean backButtonFunctionality;

    /**
     * default constructor Zurückbutton aktiviert
     */
    public BackVault(){
        backButtonFunctionality = true;
    }

    /**
     * Constructor, mit dem der default Wert der backButtonFunctionality überschrieben werden kann
     * UNUSED da die Klasse als static Object entwickelt wurde
     * @param backButtonFunctionalityOverride
     */
    public BackVault(boolean backButtonFunctionalityOverride){
        setBackButtonFunctionality(backButtonFunctionalityOverride);
    }

    /**
     * standard getter Funktion
     * @return backButtonFunctionality, true = working
     */
    public static boolean shouldAllowBack(){
        return backButtonFunctionality;
    }

    /**
     * standard setter Funktion
     * @param backButtonFunctionalityOverride überschreibt den aktuellen Wert für backButtonFunctionality
     */
    public static void setBackButtonFunctionality(boolean backButtonFunctionalityOverride){
        backButtonFunctionality = backButtonFunctionalityOverride;
    }

}
