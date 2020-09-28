package com.daisyna.medicinetime.alarm;

import com.daisyna.medicinetime.BasePresenter;
import com.daisyna.medicinetime.BaseView;
import com.daisyna.medicinetime.data.source.History;
import com.daisyna.medicinetime.data.source.MedicineAlarm;

/**
 * Created by daisyna on 13/07/17.
 */

public interface ReminderContract {

    interface View extends BaseView<Presenter> {

        void showMedicine(MedicineAlarm medicineAlarm);

        void showNoData();

        boolean isActive();

        void onFinish();

    }

    interface Presenter extends BasePresenter {

        void finishActivity();

        void onStart(long id);

        void loadMedicineById(long id);

        void addPillsToHistory(History history);

    }
}
