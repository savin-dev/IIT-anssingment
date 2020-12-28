package com.java.ui.controller;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import com.java.entity.member.DefaultMember;
import com.java.ui.models.MemberTableModel;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ScreenController implements Initializable {

    @FXML
    private TableColumn<MemberTableModel, Integer> mNoCol;

    @FXML
    private TableColumn<MemberTableModel, String> nameCol;

    @FXML
    private TableColumn<MemberTableModel, Date> dateCol;

    @FXML
    private TableColumn<MemberTableModel, String> typeCol;

    @FXML
    private TableView<MemberTableModel> tbl;

    @FXML
    private TextField txtSearch;

    private ObservableList<MemberTableModel> tblData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        mNoCol.setCellValueFactory(new PropertyValueFactory<>("membershipNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("membershipType"));

        tblData = tbl.getItems();

        populateData(GymManager.members, tblData);

        FilteredList<MemberTableModel> filterData = new FilteredList<>(tblData, pre -> true);

        txtSearch.textProperty().addListener((observable, oldVal, newVal) -> {
            filterData.setPredicate(member -> {
                if(newVal == null || newVal.isEmpty()) {
                    return true;
                }

                //return true if the name (or the part of it) matches the search
                return member.getName().toLowerCase().contains(newVal.toLowerCase());
            });

        });

        tblData = filterData;

        tbl.setItems(filterData);
    }

    private void populateData(List<DefaultMember> members, ObservableList<MemberTableModel> tblData) {

        for(DefaultMember member:members) {
            MemberTableModel model = new MemberTableModel(
              member.getMembershipNo(),
              member.getName(),
              member.getStartMembershipDate(),
              member.getMembershipType()
            );

            tblData.add(model);
        }
    }

}
