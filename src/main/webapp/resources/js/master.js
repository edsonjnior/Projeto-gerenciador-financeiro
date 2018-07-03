// UI CALENDAR SETTINGS
const format = {
    date: (date, settings) => {
        if (!date) {
            return '';
        }
        let day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
        let month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
        let year = date.getFullYear();
        return `${day}/${month}/${year}`;
    }
};

const lang = {
    days: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
    months: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    today: 'Hoje',
    now: 'Agora',
    am: 'AM',
    pm: 'PM'
};

const calendarConf = tipo => {
    return {
        text: lang,
        type: tipo,
        formatter: format,
        monthFirst: false
    };
};

// MASK MONEY SETTINGS
const moneyConf = {
    thousands: '.',
    decimal: ','
};

const intConf = {
    precision: 0,
    thousands: ''
};


// TODAY
const today = id => {
    let el = $('#' + id);
    let date = new Date();
    let day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate();
    let month = date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
    let year = date.getFullYear();
    
    $(el).val(`${day}/${month}/${year}`);
};


// MODAL
const modal = (id, modal = 'show') => $('#' + id).modal({transition: 'zoom'}).modal(modal)