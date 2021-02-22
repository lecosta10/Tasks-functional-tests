package br.ce.wcaquino.tasks_funcional;

import static org.junit.Assert.assertArrayEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesksTest {
	
	public WebDriver acessarAplicacao() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8001/tasks/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try {
			
		
		
			 driver.findElement(By.id("addTodo")).click();	
			 
			 driver.findElement(By.id("task")).sendKeys("Teste via selenium");	
			 
			 driver.findElement(By.id("dueDate")).sendKeys("10/10/2022");
			 
			 driver.findElement(By.id("saveButton")).click();
			 
			 String message = driver.findElement(By.id("message")).getText();
			 Assert.assertEquals("Sucess!", message);
		 
		} finally {
			
			 driver.quit();
		}	
		 
		
	}
		
	@Test
	public void naoDeveSalvarTarefasSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try {
		
			 driver.findElement(By.id("addTodo")).click();	
			 
			 driver.findElement(By.id("dueDate")).sendKeys("10/10/2022");
			 
			 driver.findElement(By.id("saveButton")).click();
			 
			 String message = driver.findElement(By.id("message")).getText();
			 Assert.assertEquals("Fill the task description", message);
		 
		} finally {
			
			 driver.quit();
		}	
		 
		
	}
	
	@Test
	public void deveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		try {
		
			 driver.findElement(By.id("addTodo")).click();	
			 
			 driver.findElement(By.id("task")).sendKeys("Teste via selenium");	
			 
			 driver.findElement(By.id("saveButton")).click();
			 
			 String message = driver.findElement(By.id("message")).getText();
			 Assert.assertEquals("Fill the due date", message);
		 
		} finally {
			
			 driver.quit();
		}
		
		}	
	@Test
	public void deveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		try {
				
			
			 driver.findElement(By.id("addTodo")).click();	
				 
			 driver.findElement(By.id("task")).sendKeys("Teste via selenium");	
				 
			 driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
				 
			 driver.findElement(By.id("saveButton")).click();
				 
			 String message = driver.findElement(By.id("message")).getText();
			 Assert.assertEquals("Due date must not be in past", message);
			 
		} finally {
				
			 driver.quit();
		}	
			 
			
	}	 
		
}
