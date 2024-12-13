package com.container_manager;

import java.util.Date;

import com.container_manager.adapters.HDMIDisplay;
import com.container_manager.adapters.VGADisplay;
import com.container_manager.adapters.VGAToHDMIAdapter;
import com.container_manager.entities.Agent;
import com.container_manager.entities.AgentContainer;
import com.container_manager.entities.Transaction;
import com.container_manager.enums.TransactionType;
import com.container_manager.strategies.DefaultStrategy;
import com.container_manager.strategies.HistoryStrategy;
import com.container_manager.strategies.ScoringStrategy;

public class App {
    public static void main(String[] args) {
        // creation de container
        AgentContainer container = AgentContainer.getInstance();
        container.addDisplay(new HDMIDisplay());
        container.addDisplay(new VGAToHDMIAdapter(new VGADisplay()));

        Agent a1 = new Agent("a1");
        Agent a2 = new Agent("a2");
        Agent a3 = new Agent("a3");

        a1.setStrategy(new DefaultStrategy());
        a2.setStrategy(new ScoringStrategy());
        a3.setStrategy(new HistoryStrategy());

        a2.subscribe(a1); // a1 observe a2
        a2.subscribe(a3); // a3 observe a2

        container.addAgent(a1);
        container.addAgent(a2);
        container.addAgent(a3);

        // creation des transaction
        Transaction transaction1 = new Transaction.TransactionBuilder()
                .id("1")
                .date(new Date())
                .amount(43.3)
                .type(TransactionType.ACHAT)
                .build();

        Transaction transaction2 = new Transaction.TransactionBuilder()
                .id("2")
                .date(new Date())
                .amount(100.0)
                .type(TransactionType.VENTE)
                .build();

        // 6. Tester les notifications
        System.out.println("\n=== Testing notifications ===");
        a2.addTransaction(transaction1); // a1 et a3 seront notifiés
        a2.addTransaction(transaction2); // a1 et a3 seront notifiés

        // 7. Afficher l'état final
        container.displayState();

    }
}
