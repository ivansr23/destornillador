package com.destornillador.destornillador;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


    
@RunWith(Categories.class)
@IncludeCategory({Probar.class, Probar2.class})
@SuiteClasses( { B.class }) // Note that Categories is a kind of Suite
public class ProbarCategorias {

}

